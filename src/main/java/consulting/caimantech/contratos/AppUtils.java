package consulting.caimantech.contratos;

import org.owasp.encoder.Encode;
import org.owasp.esapi.codecs.HTMLEntityCodec;
import org.owasp.esapi.logging.cleaning.CodecLogScrubber;

public class AppUtils {
	
    private static final char[] IMMUNE_SLF4J_HTML = {',', '.', '-', '_', ' ', ':','\\', '{', '}' };
    private static CodecLogScrubber codecLogScrubber = new CodecLogScrubber(new HTMLEntityCodec(), IMMUNE_SLF4J_HTML);

	public static String cleanMessage(String message, Throwable throwable) {

		// ensure there's something to log
		if (message == null) {
			message = "";
		}

		// ensure no CRLF injection into logs for forging records
		String clean = Encode.forJava(message);
		
		// encode  html
		clean = codecLogScrubber.cleanMessage(clean);
		
		if (!message.equals(clean)) {
			clean += " (Encoded)";
		}
		
		if (throwable != null) {
			String fqn = throwable.getClass().getCanonicalName();
			int index = fqn.lastIndexOf('.');
			if (index > 0) {
				fqn = fqn.substring(index + 1);
			}
			StackTraceElement ste = throwable.getStackTrace()[0];
			clean += "\n    " + fqn + " @ " + ste.getClassName() + "." + ste.getMethodName() + "(" + ste.getFileName()
					+ ":" + ste.getLineNumber() + ")";
		}
		
		return clean;
	}		
	
}
