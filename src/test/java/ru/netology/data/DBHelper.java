package ru.netology.data;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DBHelper {
    private static final String dbUrl = System.getProperty("db.url");
    private static final String dbUser = System.getProperty("db.user");
    private static final String dbPassword = System.getProperty("db.password");

    private DBHelper() {
    }

    public static String getStatusPayment() {
        val statusBD = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();

        try (
                val conn = getConnection(dbUrl, dbUser, dbPassword);
        ) {
            return runner.query(conn, statusBD, new ScalarHandler<String>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStatusCredit() {
        val statusBD = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1;";
        val runner = new QueryRunner();

        try (
                val conn = getConnection(dbUrl, dbUser, dbPassword);
        ) {
            return runner.query(conn, statusBD, new ScalarHandler<String>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void clearTables() {
        val deletePayment = "DELETE FROM payment_entity;";
        val deleteCredit = "DELETE FROM credit_request_entity;";
        val deleteOrder = "DELETE FROM order_entity;";
        val runner = new QueryRunner();

        try (
                val conn = getConnection(dbUrl, dbUser, dbPassword);
        ) {
            runner.update(conn, deletePayment);
            runner.update(conn, deleteCredit);
            runner.update(conn, deleteOrder);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
