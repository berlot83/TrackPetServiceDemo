package com.service.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
		  //File file = new File("C:/Users/user/Documents/workspace-sts-3.9.0.RELEASE/TrackPetService/WebContent/QRcodes/MyQRCode_"+value+".png");

		  String aPath = new File("").getAbsolutePath().concat("QRcodes/MyQRCode_"+value+".png");
		  File file = new File(aPath);
		  FileInputStream fileInputStreamReader = new FileInputStream(file);
		  byte[] bytes = new byte[(int)file.length()];
		  fileInputStreamReader.read(bytes);
		  String encodedFile = Base64.getEncoder().encodeToString(bytes);
		  System.out.println(encodedFile);
		  
		return encodedFile;
	}

}
