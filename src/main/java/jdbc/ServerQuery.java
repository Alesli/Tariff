package jdbc;

import java.util.Map;

/**
 * @author Скороход Олеся
 */
public class ServerQuery {

    private static ServerQuery instance;
    private Map<String, String> queries;

    private ServerQuery(Map<String, String> queries) {
        this.queries = queries;
    }

    public static ServerQuery getInstance(Map<String, String> queries) {
        if (queries != null) {
            instance = new ServerQuery(queries);
        }
        return instance;
    }

    public Map<String, String> getQueries() {
        return queries;
    }
}
