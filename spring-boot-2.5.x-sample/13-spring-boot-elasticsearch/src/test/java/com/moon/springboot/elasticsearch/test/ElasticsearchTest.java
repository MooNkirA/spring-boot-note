package com.moon.springboot.elasticsearch.test;

import com.alibaba.fastjson.JSON;
import com.moon.springboot.elasticsearch.domain.Book;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 整合 Elasticsearch 测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-28 11:25
 * @description
 */
@SpringBootTest
public class ElasticsearchTest {

    /* ES 早期低级别的客户操作对象 ElasticsearchRestTemplate，不推荐使用 */
    // @Autowired
    // private ElasticsearchRestTemplate template;

    /* ES 高级别客户操作对象 */
    private RestHighLevelClient client;

    @BeforeEach
    public void init() {
        // 指定 es 服务器地址，创建 HttpHost 连接对象。（可以修改成读取配置文件）
        HttpHost host = HttpHost.create("http://localhost:9200");
        // 创建高级别客户端操作对象
        RestClientBuilder builder = RestClient.builder(host);
        client = new RestHighLevelClient(builder);
    }

    @AfterEach
    public void shutdown() throws IOException {
        client.close();
    }

    /* 创建索引 */
    @Test
    public void testCreateIndex() throws IOException {
        // 创建索引专用的请求对象 CreateIndexRequest
        CreateIndexRequest request = new CreateIndexRequest("books");
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /* 创建索引（IK分词器） */
    @Test
    public void testCreateIndexByIK() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("books");
        String json = "{\n" +
                "    \"mappings\":{\n" +
                "        \"properties\":{\n" +
                "            \"id\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"name\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"type\":{\n" +
                "                \"type\":\"keyword\"\n" +
                "            },\n" +
                "            \"description\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\",\n" +
                "                \"copy_to\":\"all\"\n" +
                "            },\n" +
                "            \"all\":{\n" +
                "                \"type\":\"text\",\n" +
                "                \"analyzer\":\"ik_max_word\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 设置请求中的参数
        request.source(json, XContentType.JSON);
        client.indices().create(request, RequestOptions.DEFAULT);
    }

    /* 新增文档 */
    @Test
    public void testCreateDoc() throws IOException {
        Book book = new Book();
        book.setId(1);
        book.setName("金田一少年之事件薄");
        book.setType("漫画");
        book.setDescription("推理迷不能错过");
        // 创建新增的专用请求对象 IndexRequest
        IndexRequest request = new IndexRequest("books").id(book.getId().toString());
        String json = JSON.toJSONString(book);
        request.source(json, XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    @Test
    public void testCreateDocBatch() throws IOException {
        // 创建批量请求对象容器 BulkRequest
        BulkRequest bulk = new BulkRequest();

        for (int i = 2; i < 6; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("金田一少年之事件薄第" + i + "集");
            book.setType("漫画");
            book.setDescription("推理迷不能错过" + i);

            // 创建新增的专用请求对象 IndexRequest
            IndexRequest request = new IndexRequest("books").id(book.getId().toString());
            String json = JSON.toJSONString(book);
            request.source(json, XContentType.JSON);
            // 将 IndexRequest 请求对象加入到 BulkRequest 容器中
            bulk.add(request);
        }
        // 批量新增
        client.bulk(bulk, RequestOptions.DEFAULT);
    }

    /* 根据id查询文档 */
    @Test
    public void testGet() throws IOException {
        // 创建根据 id 查询文档专用请求对象 GetRequest
        GetRequest request = new GetRequest("books", "2");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        System.out.println(json);
    }

    /* 按条件查询文档 */
    @Test
    public void testSearch() throws IOException {
        // 创建条件查询文档专用请求对象 SearchRequest
        SearchRequest request = new SearchRequest("books");
        // 指定查询条件（根据哪些属性查询）
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.termQuery("all", "金田一"));
        request.source(builder);
        // 查询
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        // 获取查询命中的数据
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            String source = hit.getSourceAsString();
            System.out.println("source: " + source);
            Book book = JSON.parseObject(source, Book.class);
            System.out.println(book);
        }
    }
}
