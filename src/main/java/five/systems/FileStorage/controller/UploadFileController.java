package five.systems.FileStorage.controller;

import five.systems.FileStorage.entity.Links;
import five.systems.FileStorage.services.DownloadRepository;
import five.systems.FileStorage.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadFileController {

    @Autowired
    DownloadRepository downloadRepository;

    /**
     * Контроллер загрузки файлов
     * @author lrd
     * @date 2018/10/22
     * @param  * @param null
     * @return null
     */

        @RequestMapping(value = "/upload",method = RequestMethod.GET)
        public String upload(){
            return "/upload";
        }

        /**
         * Загрузка одного файла
         * @param file
         * @return String
         */
        @RequestMapping(value = "/upload", method = RequestMethod.POST)
        @ResponseBody
        public RedirectView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
            String contentType = file.getContentType (); // Тип файла изображения
            String fileName = FileUtil.getFileName (file.getOriginalFilename ()); // Имя изображения
            //String fileUUID = FileUtil.getUUID();
            String filePath = "resources/";

            System.out.println("Токен файла - " + fileName);
            System.out.println("Имя файла - " + file.getOriginalFilename ());

            //downloadRepository.insertPath();
            Links fdf = new Links();

            fdf.setPath(file.getOriginalFilename());
            fdf.setToken(fileName);

            downloadRepository.save(fdf);

            //downloadRepository.findAll();

            try {
                // Вызываем класс обработки файлов FileUtil для обработки файла и записи файла в указанное место
                FileUtil.uploadFile(file.getBytes(),filePath,fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8070");
            return redirectView;
        }
    }
