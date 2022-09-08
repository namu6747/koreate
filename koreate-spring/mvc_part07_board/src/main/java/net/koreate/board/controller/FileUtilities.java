package net.koreate.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public class FileUtilities {

    // Paths.get()으로 운영체제에 따라서 다른 파일구분자 처리
    public final static String rootPath = Paths.get("C:", "Users", "jihun.park", "Desktop", "testFile").toString();

    // ...

    public static String uploadCKEditorFile(MultipartFile multipartFile, String subPath) throws NoSuchAlgorithmException, IllegalStateException, IOException {

        // 파일 업로드 경로 생성
        String savePath = Paths.get(rootPath, subPath).toString();
        verifyUploadPath(savePath);

        String origFilename = multipartFile.getOriginalFilename();
        if (origFilename == null || "".equals(origFilename)) return null;

        String filename = getUuidFileName(origFilename);
        String filePath = Paths.get(savePath, filename).toString();

            File file = new File(filePath);

            // 파일 권한 설정(쓰기, 읽기)
            file.setWritable(true);
            file.setReadable(true);

            multipartFile.transferTo(file);


        return filename;
    }

    private static void verifyUploadPath(String path) {

        if (!new File(path).exists()) {
            try {
                new File(path).mkdir();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }

    /**
     * 다운로드 받을 파일 생성
     *
     * @param attach
     */
    public static File getDownloadFile(String filaName, String subPath) {

        return new File(Paths.get(rootPath, subPath).toString(), filaName);
    }

    /**
     * 파일명 중복 방지를 위해 UUID 파일명 생성
     *
     * @param filename
     * @return
     */
    public static String getUuidFileName(String filename) {

        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append(FilenameUtils.getBaseName(filename))
            .append("_").append(uuid).append(".").append(FilenameUtils.getExtension(filename));

        return  sb.toString();
    }

    // ...

    /**
     * MediaType 생성
     *
     * @param filename
     */
    public static MediaType getMediaType(String filename) {

        String contentType = FilenameUtils.getExtension(filename);
        MediaType mediaType = null;

        if (contentType.equals("png")) {
            mediaType = MediaType.IMAGE_PNG;
        } else if (contentType.equals("jpeg") || contentType.equals("jpg")) {
            mediaType = MediaType.IMAGE_JPEG;
        } else if (contentType.equals("gif")) {
            mediaType = MediaType.IMAGE_GIF;
        }

        return mediaType;
    }
}
