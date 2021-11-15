/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
