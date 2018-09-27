package com.service.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Base64;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {

	public static String generateQRCodeImageToBase64(String text, int width, int height, String filePath, String value)
			throws WriterException, IOException, URISyntaxException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
		  File file = new File("");
		  FileInputStream fileInputStreamReader = new FileInputStream(file);
		  byte[] bytes = new byte[(int)file.length()];
		  fileInputStreamReader.read(bytes);
		  String encodedFile = Base64.getEncoder().encodeToString(bytes);
		  System.out.println(encodedFile);
		  
		  return encodedFile;
	}
	
	public static void main(String[] args) throws WriterException, IOException, URISyntaxException {
	//	QRCodeGenerator.generateQRCodeImageToBase64("Hola mundo", 300, 300, "Test","m");
		URL pathTemp = new URL("https://pets2018.herokuapp.com/QRcodes/MyQRCode_.png");
		System.out.println(pathTemp);
	}

}
