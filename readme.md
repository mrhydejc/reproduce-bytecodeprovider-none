Reproducer for the following error:

`org.hibernate.HibernateException: Generation of HibernateProxy instances at runtime is not allowed when the configured BytecodeProvider is 'none'; your model requires a more advanced BytecodeProvider to be enabled.`

# Build the multi-module project
`mvn clean install`

# Working example with regular jvm :
open server dir
`mvn spring-boot:run`
goto http://127.0.0.1:8080/read

# Not working example with a native image
open server dir
```
mvn -Pnative spring-boot:build-image &&
docker run -p 8080:8080 docker.io/library/reproduce-server:0.0.1-SNAPSHOT
```

goto http://127.0.0.1:8080/read

Sample stacktrace:

```
2023-01-06T09:56:16.246+01:00 ERROR 152864 --- [nio-8080-exec-3] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.springframework.orm.jpa.JpaSystemException: Generation of HibernateProxy instances at runtime is not allowed when the configure
d BytecodeProvider is 'none'; your model requires a more advanced BytecodeProvider to be enabled.] with root cause

org.hibernate.HibernateException: Generation of HibernateProxy instances at runtime is not allowed when the configured BytecodeProvider is 'none'; your model requires a more advanced BytecodeProvider to be enabled.
        at org.hibernate.bytecode.internal.none.DisallowedProxyFactory.getProxy(DisallowedProxyFactory.java:34) ~[na:na]
        at org.hibernate.persister.entity.AbstractEntityPersister.createProxy(AbstractEntityPersister.java:5001) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.hibernate.event.internal.DefaultLoadEventListener.createProxy(DefaultLoadEventListener.java:463) ~[na:na]
        at org.hibernate.event.internal.DefaultLoadEventListener.createProxyIfNecessary(DefaultLoadEventListener.java:453) ~[na:na]
        at org.hibernate.event.internal.DefaultLoadEventListener.proxyOrLoad(DefaultLoadEventListener.java:357) ~[na:na]
        at org.hibernate.event.internal.DefaultLoadEventListener.doOnLoad(DefaultLoadEventListener.java:113) ~[na:na]
        at org.hibernate.event.internal.DefaultLoadEventListener.onLoad(DefaultLoadEventListener.java:75) ~[na:na]
        at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:118) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.hibernate.internal.SessionImpl.fireLoadNoChecks(SessionImpl.java:1244) ~[na:na]
        at org.hibernate.internal.SessionImpl.internalLoad(SessionImpl.java:1097) ~[na:na]
        at org.hibernate.sql.results.graph.entity.internal.EntityDelayedFetchInitializer.resolveInstance(EntityDelayedFetchInitializer.java:164) ~[na:na]
        at org.hibernate.sql.results.internal.StandardRowReader.coordinateInitializers(StandardRowReader.java:147) ~[na:na]
        at org.hibernate.sql.results.internal.StandardRowReader.readRow(StandardRowReader.java:97) ~[na:na]
        at org.hibernate.sql.results.spi.ListResultsConsumer.consume(ListResultsConsumer.java:198) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.hibernate.sql.results.spi.ListResultsConsumer.consume(ListResultsConsumer.java:33) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.doExecuteQuery(JdbcSelectExecutorStandardImpl.java:443) ~[na:na]
        at org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.executeQuery(JdbcSelectExecutorStandardImpl.java:166) ~[na:na]
        at org.hibernate.sql.exec.internal.JdbcSelectExecutorStandardImpl.list(JdbcSelectExecutorStandardImpl.java:91) ~[na:na]
        at org.hibernate.sql.exec.spi.JdbcSelectExecutor.list(JdbcSelectExecutor.java:31) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.lambda$new$0(ConcreteSqmSelectQueryPlan.java:113) ~[na:na]
        at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.withCacheableSqmInterpretation(ConcreteSqmSelectQueryPlan.java:335) ~[na:na]
        at org.hibernate.query.sqm.internal.ConcreteSqmSelectQueryPlan.performList(ConcreteSqmSelectQueryPlan.java:276) ~[na:na]
        at org.hibernate.query.sqm.internal.QuerySqmImpl.doList(QuerySqmImpl.java:571) ~[na:na]
        at org.hibernate.query.spi.AbstractSelectionQuery.list(AbstractSelectionQuery.java:363) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.hibernate.query.sqm.internal.QuerySqmImpl.list(QuerySqmImpl.java:1073) ~[na:na]
        at org.hibernate.query.Query.getResultList(Query.java:94) ~[reproduce-bytecodeprovider-none.exe:6.1.6.Final]
        at org.springframework.data.jpa.repository.support.SimpleJpaRepository.findAll(SimpleJpaRepository.java:405) ~[reproduce-bytecodeprovider-none.exe:3.0.0]
        at java.base@17.0.5/java.lang.reflect.Method.invoke(Method.java:568) ~[reproduce-bytecodeprovider-none.exe:na]
        at org.springframework.data.repository.core.support.RepositoryMethodInvoker$RepositoryFragmentMethodInvoker.lambda$new$0(RepositoryMethodInvoker.java:288) ~[na:na]
        at org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:136) ~[reproduce-bytecodeprovider-none.exe:3.0.0]
        at org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:120) ~[reproduce-bytecodeprovider-none.exe:3.0.0]
        at org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:516) ~[reproduce-bytecodeprovider-none.exe:3.0.0]
        at org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:285) ~[na:na]
        at org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:628) ~[na:na]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:168) ~[na:na]
        at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:143) ~[na:na]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:77) ~[na:na]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123) ~[na:na]
        at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137) ~[na:na]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:163) ~[na:na]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97) ~[na:na]
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:218) ~[na:na]
        at jdk.proxy4/jdk.proxy4.$Proxy48.findAll(Unknown Source) ~[na:na]
        at com.example.reproducebytecodeprovidernone.EntityHandler.loadById(EntityHandler.java:25) ~[reproduce-bytecodeprovider-none.exe:na]
        at com.example.reproducebytecodeprovidernone.RestController.load(RestController.java:22) ~[reproduce-bytecodeprovider-none.exe:na]
        at java.base@17.0.5/java.lang.reflect.Method.invoke(Method.java:568) ~[reproduce-bytecodeprovider-none.exe:na]
        at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:207) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:152) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:884) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:797) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1080) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:973) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1010) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:902) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:705) ~[reproduce-bytecodeprovider-none.exe:6.0]
        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:884) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:814) ~[reproduce-bytecodeprovider-none.exe:6.0]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:223) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[reproduce-bytecodeprovider-none.exe:10.1.4]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
        at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
        at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
        at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[reproduce-bytecodeprovider-none.exe:6.0.3]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:185) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:158) ~[na:na]
        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:177) ~[na:na]
        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[na:na]
        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) ~[reproduce-bytecodeprovider-none.exe:10.1.4]
        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:119) ~[na:na]
        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[reproduce-bytecodeprovider-none.exe:10.1.4]
        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[na:na]
        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) ~[na:na]
        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:400) ~[na:na]
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[reproduce-bytecodeprovider-none.exe:10.1.4]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:859) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1734) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[reproduce-bytecodeprovider-none.exe:10.1.4]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[na:na]
        at java.base@17.0.5/java.lang.Thread.run(Thread.java:833) ~[reproduce-bytecodeprovider-none.exe:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:775) ~[reproduce-bytecodeprovider-none.exe:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.windows.WindowsPlatformThreads.osThreadStartRoutine(WindowsPlatformThreads.java:178) ~[na:na]

```
