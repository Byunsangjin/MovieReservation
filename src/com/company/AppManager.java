package com.company;

public class AppManager {
    private static AppManager appManager = null;
    private DAOManager m_daoManager;
    private DataManager m_dataManager;
    private LoginView m_loginView;
    private MyActionListener m_myactionlistener;
    private MainView m_mainView;

    // 싱글톤 패턴
    public static AppManager getInstance(){
        if(appManager == null)
            appManager = new AppManager();
        return appManager;
    }

    public void setDAOManager (DAOManager daoManager) {
        m_daoManager = daoManager;
    }
    public void setDataManager (DataManager dataManager) {
        m_dataManager = dataManager;
    }
    public void setLoingView(LoginView loingView){ m_loginView = loingView; }
    public void setMyactionListener (MyActionListener myactionlistener) { m_myactionlistener = myactionlistener; }
    public void setMainView (MainView mainView) { m_mainView = mainView; }

    public DataManager getDataManager() {
        return m_dataManager;
    }
    public DAOManager getDAOManager() {
        return m_daoManager;
    }
    public LoginView getLoginView() { return m_loginView; }
    public MyActionListener getMyactionListener() { return m_myactionlistener; }

    public MainView getMainView() { return m_mainView; }
}
