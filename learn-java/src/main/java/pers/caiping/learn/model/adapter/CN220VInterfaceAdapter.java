package pers.caiping.learn.model.adapter;

/**
 * 110V电压的 220V 接口适配器
 */
public class CN220VInterfaceAdapter implements JP110VInterface {

    private CN220VInterface cn220VInterface;

    public CN220VInterfaceAdapter(CN220VInterface cn220VInterface) {
        this.cn220VInterface = cn220VInterface;
    }

    @Override
    public void connect() {
        cn220VInterface.connect();
    }
}
