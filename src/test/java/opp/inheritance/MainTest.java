package opp.inheritance;
import oop.inheritance.Application;
import oop.inheritance.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import oop.inheritance.data.SupportedTerminal;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainTest {
    class ApplicationStub extends Application {
        boolean clearScreenCalled;
        boolean showMenuCalled;
        boolean doSaleCalled;
        boolean doRefundCalled;
        boolean printReportCalled;
        boolean showConfigurationCalled;
        boolean readKeyCalled;
        String key;
        public ApplicationStub(String key){
            super(SupportedTerminal.INGENICO);
            this.key = key;
        }
        @Override
        public void clearScreen(){
            clearScreenCalled = true;
        }
        @Override
        public void showMenu(){
            showMenuCalled = true;
        }
        @Override
        public String readKey(){
            readKeyCalled = true;
            return key;
        }
        @Override
        public void doSale(){
            doSaleCalled = true;
        }
        @Override
        public void doRefund(){
            doRefundCalled =true;
        }
        @Override
        public void printReport(){
            printReportCalled = true;
        }
        public void showConfiguration(){
            showConfigurationCalled = true;
        }
    }


    @Test
    public void when1IsTyped_thenSaleIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);
        when(application.readKey()).thenReturn("1");
        //when
        Main.run(application);
        //then
        verify(application).clearScreen();
        verify(application).showMenu();
        verify(application).readKey();
        verify(application).doSale();
        verifyNoMoreInteractions(application);
    }
    @Test
    public void when2IsTyped_thenRefundIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);
        when(application.readKey()).thenReturn("2");
        //when
        Main.run(application);
        //then
        verify(application).clearScreen();
        verify(application).showMenu();
        verify(application).readKey();
        verify(application).doRefund();
        verifyNoMoreInteractions(application);

    }
    @Test
    public void when3IsTyped_thePrintReportIsCalled() {
        //Given
        Application application = Mockito.mock(Application.class);
        when(application.readKey()).thenReturn("3");
        //when
        Main.run(application);
        //then
        verify(application).clearScreen();
        verify(application).showMenu();
        verify(application).readKey();
        verify(application).printReport();
        verifyNoMoreInteractions(application);
    }

    @Test
    public void when4IsTyped_theShowMenuIsCalled(){
        //Given
        Application application = Mockito.mock(Application.class);
        when(application.readKey()).thenReturn("4");
        //when
        Main.run(application);
        //then
        verify(application).clearScreen();
        verify(application).showMenu();
        verify(application).readKey();
        verify(application).showConfiguration();
        verifyNoMoreInteractions(application);

    }
}



