package com.acubiz.export.transform;

import com.acubiz.export.transform.config.ConfigModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootApplication
public class TransformApplication {

	public static final String INPUTFILENAME = "./src/main/resources/files/EMS_EA-20181104-233634.csv";
	public static final String CONFIGFILENAME = "./src/main/resources/files/config_example.json";

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(TransformApplication.class, args);
		Reader in = new FileReader(INPUTFILENAME);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';')
				.withFirstRecordAsHeader()
				.parse(in);
		String outputModel = "";

		ConfigModel configModel = null;
		String result = "";
		for (CSVRecord record : records) {
			String recordNumber = record.get("RecordNO#txt");
			String purchaseDate = record.get("PurchaseDate#date");
			System.out.println(recordNumber + ", " + purchaseDate);
			result = transform(configModel, record, outputModel);
		}
		System.out.println("Result : " + result);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String jsonAsString = readFile(CONFIGFILENAME);
		configModel = objectMapper.readValue(jsonAsString, ConfigModel.class);
		System.out.println("--->" + configModel);

	}

	private static String transform(ConfigModel configModel, CSVRecord record, String outputModel) {
		return "OK";
	}

	private static String readFile(String filePath)
	{
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}


}
