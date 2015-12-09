package headfirst.decorator.io;

import java.io.*;

public class UpperCaseInputStream extends FilterInputStream {
	public UpperCaseInputStream(InputStream in) 
	{
		super(in);
	}
	
	public int read() throws IOException
	{
		int ch = in.read();
		if(ch < 0)
			return ch;
		if(Character.isLowerCase((char)ch))
			return Character.toUpperCase((char)ch);
		return ch;
	}

	public int read(byte[] b) throws IOException
	{
		int r = in.read(b);

		for(int i = 0;  i < r;  i++)
			if(Character.isUpperCase((char)b[i]))
				b[i] = (byte)Character.toUpperCase((char)b[i]);

		return r;
	}

	public int read(byte[] b, int off, int len) throws IOException
	{
		int r = in.read(b, off, len);

		for(int i = off;  i < off + r;  i++)
			if(Character.isUpperCase((char)b[i]))
				b[i] = (byte)Character.toUpperCase((char)b[i]);

		return r;
	}
}
