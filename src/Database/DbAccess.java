package Database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccess {
    private String path;
    private final String defaultPath = "C:/Users/Robert/Documents/IdeaProjects_Ultimate/RecipeApp/";
    protected String url;

    public DbAccess(String path) {
        if (path.contains("/") & path.contains("\\")) {
            this.path = path;
        } else {
            this.path = defaultPath + path;
        }
        File db = new File(path);
        url = "jdbc:sqlite:" + path;

    }

    protected Connection connect() {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
