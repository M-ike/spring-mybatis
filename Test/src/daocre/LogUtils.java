package daocre;



import org.apache.maven.plugin.logging.Log;

public class LogUtils {

	public static Log logger;

	static {

		logger = new Log() {

			public boolean isDebugEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			public void debug(CharSequence charsequence) {
				// TODO Auto-generated method stub

			}

			public void debug(CharSequence charsequence, Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public void debug(Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public boolean isInfoEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			public void info(CharSequence charsequence) {
				System.out.println(charsequence);
			}

			public void info(CharSequence charsequence, Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public void info(Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public boolean isWarnEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			public void warn(CharSequence charsequence) {
				// TODO Auto-generated method stub

			}

			public void warn(CharSequence charsequence, Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public void warn(Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public boolean isErrorEnabled() {
				// TODO Auto-generated method stub
				return false;
			}

			public void error(CharSequence charsequence) {
				// TODO Auto-generated method stub

			}

			public void error(CharSequence charsequence, Throwable throwable) {
				// TODO Auto-generated method stub

			}

			public void error(Throwable throwable) {
				// TODO Auto-generated method stub

			}

		};
	}
}
