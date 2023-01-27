package tw.com.firstbank.fcbcore.fir.service.application.in.core;

public interface UseCaseApi <I extends RequestCommand, O extends ResponseCommand> {

  O execute(I requestCommand);

}
