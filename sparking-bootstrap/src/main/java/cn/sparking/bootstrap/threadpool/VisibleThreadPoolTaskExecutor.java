
package cn.sparking.bootstrap.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class VisibleThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(VisibleThreadPoolTaskExecutor.class);

    private void showThreadPoolInfo(final String prefix) {
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();
        if (!ObjectUtils.isEmpty(threadPoolExecutor)) {
            LOG.info("Current Thread Pool Info => {}", threadPoolExecutor);
        }
    }

    @Override
    public void execute(final Runnable task) {
        showThreadPoolInfo("one. do execute");
        super.execute(task);
    }

    @Override
    public void execute(final Runnable task, final long startTimeout) {
        showThreadPoolInfo("two. do execute");
        super.execute(task, startTimeout);
    }

    @Override
    public Future<?> submit(final Runnable task) {
        showThreadPoolInfo("one. do submit");
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(final Callable<T> task) {
        showThreadPoolInfo("two. do submit");
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(final Runnable task) {
        showThreadPoolInfo("one. do submitListenable");
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(final Callable<T> task) {
        showThreadPoolInfo("two. do submitListenable");
        return super.submitListenable(task);
    }
}
