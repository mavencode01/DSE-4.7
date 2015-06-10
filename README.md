# DSE-4.7
Reproduce issue in DSE 4.7 - Version mismatch


## POM file

     <properties>
		  <scala.version>2.10.4</scala.version>
		  <scala.binary.version>2.10</scala.binary.version>
		  <scala.macros.version>2.0.1</scala.macros.version>
		  <spark.version>1.2.1</spark.version>
	  </properties>
	
	<dependencies>

		<dependency>
			<groupId>org.scala-lang</groupId>
			<artifactId>scala-compiler</artifactId>
			<version>${scala.version}</version>
		</dependency>
		<dependency>
			<groupId>org.scala-lang</groupId>
			<artifactId>scala-library</artifactId>
			<version>${scala.version}</version>
		</dependency>

		<dependency>
			<groupId>org.apache.spark</groupId>
			<artifactId>spark-core_${scala.binary.version}</artifactId>
			<version>${spark.version}</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.spark</groupId>
			<artifactId>spark-sql_${scala.binary.version}</artifactId>
			<version>${spark.version}</version>
		</dependency>

		<dependency>
			<groupId>org.apache.spark</groupId>
			<artifactId>spark-streaming_${scala.binary.version}</artifactId>
			<version>${spark.version}</version>
		</dependency>


		<dependency>
			<groupId>com.datastax.spark</groupId>
			<artifactId>spark-cassandra-connector-java_2.10</artifactId>
			<version>${spark.version}</version>
		</dependency>
	

		<dependency>
			<groupId>com.datastax</groupId>
			<artifactId>dse</artifactId>
			<version>4.7.0</version>
			<scope>system</scope>
			<systemPath>${project.basedir}/lib/dse-4.7.0.jar</systemPath>
		</dependency>

	</dependencies>
	
	

## Error
  
INFO  [sparkMaster-akka.actor.default-dispatcher-2] 2015-06-10 10:52:34,295  Logging.scala:59 - akka.tcp://sparkDriver@mvaencode.net:36003 got disassociated, removing it.
ERROR [sparkMaster-akka.actor.default-dispatcher-4] 2015-06-10 10:52:34,295  Slf4jLogger.scala:66 - org.apache.spark.deploy.ApplicationDescription; ````local class incompatible: stream classdesc serialVersionUID = 7674242335164700840````, local cla
java.io.InvalidClassException: org.apache.spark.deploy.ApplicationDescription; local class incompatible: stream classdesc serialVersionUID = 7674242335164700840, local class serialVersionUID = 2812534333379744973
