package com.sample.config;

import com.atomikos.icatch.jta.J2eeUserTransaction;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;

/**
 * Created by USER on 2017-12-29.
 */
public class TransactionManageConfig {

    @Bean(name = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
    public UserTransactionManager atomikosTransactionManager()  {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    @Bean(name = "atomikosUserTransaction")
    public J2eeUserTransaction atomikosUserTransaction() throws Exception {
        J2eeUserTransaction j2eeUserTransaction = new J2eeUserTransaction();
        j2eeUserTransaction.setTransactionTimeout(300);
        return j2eeUserTransaction;
    }

    @Bean(name = "transactionManager")
    @DependsOn(value = { "atomikosTransactionManager", "atomikosUserTransaction" })
    public JtaTransactionManager transactionManager() throws Exception {
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        transactionManager.setTransactionManager(atomikosTransactionManager());
        transactionManager.setUserTransaction(atomikosUserTransaction());
        transactionManager.setAllowCustomIsolationLevels(true);

        return transactionManager;
    }


}
