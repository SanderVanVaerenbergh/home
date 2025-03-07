package be.sander.thuis.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@DataJpaTest
public class DataSourceTest {
    private final DataSource dataSource;

    DataSourceTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Test
    void getConnection() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
        }
    }
}
