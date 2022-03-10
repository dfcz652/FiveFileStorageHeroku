package five.systems.FileStorage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinksServiceImpl implements LinksService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getPathsForLinks() {
        String textSQL = "select 'FileStorage/resources/'||l.token::TEXT AS file_token, ";
        textSQL = textSQL + "l.path::TEXT AS path ";
        textSQL = textSQL + "from links l";

        List<Map<String, Object>> listPathsForLinks = jdbcTemplate.queryForList(textSQL);
        return listPathsForLinks;
    }
}
