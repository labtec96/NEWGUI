/**
 *
 *  @author Han Cezary S15831
 *
 */

package zadanie2;


public class Main {
  public static void main(String[] args) throws InterruptedException {
    StringTask task = new StringTask("A", 70000);
    System.out.println("Task " + task.getState());
    task.start();
		if (args.length > 0 && args[0].equals("abort")) {
			new Thread(() ->{
				try
				{
						Thread.sleep(800);

				} catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
				task.abort();
			}).start();
		}
    while (!task.isDone()) {
      Thread.sleep(500);
      switch(task.getState()) {
        case RUNNING: System.out.print("R."); break;
        case ABORTED: System.out.println(" ... aborted."); break;
        case READY: System.out.println(" ... ready."); break;
        default: System.out.println("unknown state");
      }

    }
    System.out.println("Task " + task.getState());
    System.out.println(task.getResult().length());
  }
}
