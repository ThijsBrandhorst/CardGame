package interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import database.factories.DAOFactories;
import database.factories.DAOFactory;
import database.session.HibernateSessionManager;

public class LoggingInterceptor implements Interceptor {

    @Override
    public void destroy() {
        HibernateSessionManager.shutdown();
    }

    @Override
    public void init() {
        DAOFactory.setTheFactory(DAOFactories.HIBERNATE.getTheFactory());
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // Pre-processing logic
        System.out.println("Before invoking action: " + invocation.getAction().getClass().getName());

        // Invoke the action or the next interceptor in the chain
        String result = invocation.invoke();

        // Post-processing logic
        System.out.println("After invoking action: " + invocation.getAction().getClass().getName());

        return result;
    }
}
