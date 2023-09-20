package com.mall.management.DBConnect;

import lombok.Cleanup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class DataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnect() throws SQLException {
        @Cleanup
        Connection con = dataSource.getConnection();
        Assertions.assertNotNull(con);
    }
}
