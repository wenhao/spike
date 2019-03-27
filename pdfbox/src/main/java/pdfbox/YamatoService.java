package pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YamatoService {

    public static void main(String[] args) throws Exception {
        YamatoService yamatoService = new YamatoService();
        String pdfBase64String = yamatoService.readAsString("base64string.txt");
        String pdfText = yamatoService.readYamatoLabelPdfAsString(pdfBase64String);
        Arrays.stream(pdfText.split("\\r?\\n"))
                .forEach(System.out::println);
    }

    private String readYamatoLabelPdfAsString(String pdfBase64String) throws IOException {
        byte[] bytes = Base64.getDecoder().decode(pdfBase64String);
        PDDocument pdDocument = PDDocument.load(bytes);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        return pdfTextStripper.getText(pdDocument);
    }

    private String readAsString(String path) {
        try {
            Path filePath = Paths.get(getClass().getClassLoader().getResource(path).toURI());
            Stream<String> lines = Files.lines(filePath);
            String content = lines.collect(Collectors.joining("\n"));
            lines.close();
            return content;
        } catch (Exception e) {
            throw new FileSystemNotFoundException(path + " file not found.");
        }
    }
}
