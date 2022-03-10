package five.systems.FileStorage.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

@Configuration
public class UploadFileConfiguration {

    /**
     * Конфигурация загрузки файла
     * @author lrd
     * @date 2018/10/22
     * @param * @param null
     * @return  null
     */
        @Bean
        public MultipartConfigElement multipartConfigElement(){
            MultipartConfigFactory factory = new MultipartConfigFactory();
            // Устанавливаем лимит размера файла. Превышение страницы настройки вызовет сообщение об исключении.
            //factory.setMaxFileSize(DataSize.parse("256KB"));
            // Установить общий размер загружаемого файла
            //factory.setMaxRequestSize(DataSize.parse("512KB"));
            return factory.createMultipartConfig();
        }
    }

