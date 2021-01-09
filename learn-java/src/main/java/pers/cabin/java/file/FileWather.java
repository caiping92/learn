package pers.cabin.java.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import pers.cabin.java.StdOut;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FileWather {

    public static void main(String[] args) {

        FileWather.registerFileWatcher("D:/tmp");

        StdOut.println("registerFileWatcher(\"D:/tmp\") finished");

    }


    private FileWather() {
    }

    public static void registerFileWatcher(String path) {

        IOFileFilter direcoryFilter = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
        IOFileFilter fileFilter = FileFilterUtils.and(FileFilterUtils.fileFileFilter()/*, FileFilterUtils.suffixFileFilter("*.properties")*/);

        IOFileFilter filter = FileFilterUtils.or(direcoryFilter, fileFilter);

//        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(path, filter);
        FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(path, direcoryFilter);


        fileAlterationObserver.addListener(new FileListener(path));
        FileAlterationMonitor monitor = new FileAlterationMonitor(1000, fileAlterationObserver);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class MemoryStore {
        private String perfix;
        private String location;

        public MemoryStore(String perfix, String location) {
            this.perfix = perfix;
            this.location = location;
        }

        public void onChange() {
            // need parse event

        }
    }

    public static class FileListener extends FileAlterationListenerAdaptor {

        private static final ReentrantLock lock = new ReentrantLock(true);
        private static final Condition sig = lock.newCondition();

        private static final Map<String, MemoryStore> filePools = new ConcurrentHashMap<>();

        private final String prefix;

        public FileListener(String perfix) {
            this.prefix = perfix;

            Collection<File> files = FileUtils.listFiles(new File(perfix), null, true);
            files.stream().filter(File::isFile)
                    .map(File::getAbsolutePath)
                    .forEach(fn -> {
                        StdOut.println("load " + fn);
                        filePools.put(fn, new MemoryStore(perfix, fn));
                    });
        }

        @Override
        public void onDirectoryCreate(File file) {
            lock.lock();
            try {
                StdOut.println(file.getAbsolutePath() + " onDirectoryCreate ");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onDirectoryChange(File file) {
            lock.lock();
            try {
                StdOut.println(file.getAbsolutePath() + " onDirectoryChange ");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onDirectoryDelete(File file) {
            lock.lock();
            try {
                StdOut.println(file.getAbsolutePath() + " onDirectoryDelete ");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onFileCreate(File file) {
            lock.lock();
            try {
                StdOut.println(file.getAbsolutePath() + " onFileCreate ");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onFileChange(File file) {
            lock.lock();
            try {
                StdOut.println(file.getAbsolutePath() + " onFileChange ");
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onFileDelete(File file) {
            StdOut.println(file.getAbsolutePath() + " onFileDelete ");

        }

    }


}
