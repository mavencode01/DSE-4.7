
package com.mavencode;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SchemaRDD;
import org.apache.spark.sql.cassandra.CassandraSQLContext;
import org.apache.spark.sql.catalyst.expressions.Row;

public class SparkSQLTest {
	
private static final String KEYSPACE = "LogReport";

  public static void main(String[] args) throws Exception {
	  
    SparkConf sparkConf = new SparkConf(true)
    							.setAppName("SparkSQLDemo")
    							.setMaster("spark://10.0.0.204:7077")
//    							.setMaster("local[2]")
    							.set("spark.cassandra.connection.host", "10.0.0.203");
//							    .set("cassandra.username","cassandra")
//							    .set("cassandra.password","cassandra");
    
    
    SparkContext sparkCtx = new SparkContext(sparkConf);   
    CassandraSQLContext cassandraContext = new CassandraSQLContext(sparkCtx);
    cassandraContext.setKeyspace(KEYSPACE);
    
    SchemaRDD logs = cassandraContext.sql("SELECT * FROM dailylogs");
    logs.registerTempTable("logs");
    
    
    for (Row row : logs.collect()){
        System.out.println(row);
    }
    
    //ctx.stop();
  }
}