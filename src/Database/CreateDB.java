package Database;

import java.io.File;
import java.sql.*;

public class CreateDB extends DbAccess {

    public CreateDB(String path) {
        super(path);

        createNewDatabase();
        createRecipesTable();
        createIngredientsTable();
        createDirectionsTable();

    }

    private void createNewDatabase() {
        try (Connection conn = this.connect();){
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createRecipesTable() {
        String sql = "CREATE TABLE IF NOT EXISTS recipes (\n"
                + "	recipeID integer PRIMARY KEY,\n"
                + "	title text NOT NULL,\n"
                + " course text,\n"
                + " category text,\n"
                + " imgSRC text,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createDirectionsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS directions (\n"
                + "	directionID integer PRIMARY KEY,\n"
                + " recipeID integer NOT NULL,\n"
                + " stepNum integer NOT NULL,\n"
                + "	direction text NOT NULL,\n"
                + " FOREIGN KEY (recipeID)\n"
                + "     REFERENCES recipes (recipeID)\n"
                + ");";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createIngredientsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS ingredients (\n"
                + "	ingredientID integer PRIMARY KEY,\n"
                + " recipeID integer NOT NULL,\n"
                + " ingredientCat integer,\n"
                + "	ingredient text NOT NULL,\n"
                + " FOREIGN KEY (recipeID)\n"
                + "     REFERENCES recipes (recipeID)\n"
                + ");";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}