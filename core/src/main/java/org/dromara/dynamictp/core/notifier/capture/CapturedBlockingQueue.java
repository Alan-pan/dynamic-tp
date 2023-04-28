package org.dromara.dynamictp.core.notifier.capture;

import org.dromara.dynamictp.core.support.ExecutorAdapter;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ruoan
 * @since 1.1.3
 */
public class CapturedBlockingQueue extends AbstractQueue<Runnable> implements BlockingQueue<Runnable> {

    private final int size;

    private final int remainingCapacity;

    private final int queueCapacity;

    private final String queueType;

    private final BlockingQueue<Runnable> originQueue;

    public CapturedBlockingQueue(ExecutorAdapter<?> executorAdapter) {
        this.size = executorAdapter.getQueueSize();
        this.remainingCapacity = executorAdapter.getQueueRemainingCapacity();
        this.queueCapacity = executorAdapter.getQueueCapacity();
        this.queueType = executorAdapter.getQueueType();
        this.originQueue = executorAdapter.getQueue();
    }

    public BlockingQueue<Runnable> getOriginQueue() {
        return originQueue;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public String getQueueType() {
        return queueType;
    }

    @Override
    public Iterator<Runnable> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(Runnable runnable) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offer(Runnable runnable, long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Runnable take() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Runnable poll(long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int remainingCapacity() {
        return remainingCapacity;
    }

    @Override
    public int drainTo(Collection<? super Runnable> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int drainTo(Collection<? super Runnable> c, int maxElements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean offer(Runnable runnable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Runnable poll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Runnable peek() {
        throw new UnsupportedOperationException();
    }
}
