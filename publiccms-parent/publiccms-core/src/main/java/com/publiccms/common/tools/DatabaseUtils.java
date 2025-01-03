package com.publiccms.common.tools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.publiccms.common.constants.CommonConstants;
import com.publiccms.common.database.CmsDataSource;

/**
 *
 * DatabaseUtils
 * 
 */
public class DatabaseUtils {

    private DatabaseUtils() {
    }

    /**
     * @param databaseConfigFile
     * @return connection
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection(String databaseConfigFile) throws SQLException, IOException, ClassNotFoundException {
        Properties dbconfigProperties = CmsDataSource.loadDatabaseConfig(databaseConfigFile);
        String driverClassName = dbconfigProperties.getProperty("jdbc.driverClassName");
        String url = dbconfigProperties.getProperty("jdbc.url");
        String userName = dbconfigProperties.getProperty("jdbc.username");
        String password = getPassword(dbconfigProperties);
        return getConnection(driverClassName, url, userName, password);
    }

    @SuppressWarnings("deprecation")
    public static String getPassword(Properties properties) {
        String password = properties.getProperty("jdbc.password");
        String encryptPassword = properties.getProperty("jdbc.encryptPassword");
        if (null != encryptPassword) {
            password = VerificationUtils.decryptAES(VerificationUtils.base64Decode(encryptPassword), CommonConstants.ENCRYPT_KEY);
            if (CommonUtils.empty(password)) {
                password = VerificationUtils.decrypt3DES(VerificationUtils.base64Decode(encryptPassword),
                        CommonConstants.ENCRYPT_KEY);
            }
        }
        return password;
    }

    /**
     * @param driverClassName
     * @param url
     * @param userName
     * @param password
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection(String driverClassName, String url, String userName, String password)
            throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);
        return DriverManager.getConnection(url, userName, password);
    }
}
