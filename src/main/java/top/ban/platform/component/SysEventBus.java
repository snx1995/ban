package top.ban.platform.component;

import top.ban.platform.component.event.SysEvent;

import java.util.concurrent.ConcurrentHashMap;

public final class SysEventBus {
    static {
        System.out.println("SysEventBus Created!");
    }

    private static ConcurrentHashMap<Enum, Object> listeners;

    public static void addListener(Enum event, Listener listener) {

    }

    public interface Listener {
        void onEventEmit(SysEvent event);
    }
}
