import java.io.*;
import java.math.*;
import java.util.*;

// author : Multi-Thread

public class Main {
	static int INF = (int) 1e9 + 7;

//	static StringBuffer ans = new StringBuffer();
	public static void main(String[] args) {
//		int test = fs.nextInt();

		int test = 1;

		for (int cases = 0; cases < test; cases++) {

			solve();
//			System.out.println(solve());

//			ans.append(solve() + "\n");
		}

//		out.print(ans);
//		out.flush();
	}

	static void solve() {
		int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
		int ar[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ar[i][j] = fs.nextInt();
			}
		}
		int ans = 0;
		// horz
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m;) {
				if (ar[i][j] == 1) {
					int c = 1;
					int z = j + 1;
					for (; z < m; z++) {
						if (ar[i][z] == 1) {
							++c;
						} else {
							break;
						}
					}
					j = z;
					if (c >= k) {
						ans = (ans % INF + (c - k + 1) % INF) % INF;
					}
				} else {
					++j;
					continue;
				}
			}
		}
		// vert
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n;) {
				if (ar[i][j] == 1) {
					int c = 1;
					int z = i + 1;
					for (; z < n; z++) {
						if (ar[z][j] == 1) {
							++c;
						} else {
							break;
						}
					}
					i = z;
					if (c >= k) {
						ans = (ans % INF + (c - k + 1) % INF) % INF;
					}
				} else {
					++i;
					continue;
				}
			}
		}
		// right diag
		for (int i = 0; i < n; i++) {
			int x = i;
			int y = 0;
			int c = 0;
			while (x >= 0 && y < m) {
				if (ar[x][y] == 1) {
					++c;
				} else {
					if (c >= k) {
						ans = (ans % INF + (c - k + 1) % INF) % INF;
					}
					c = 0;
				}
				--x;
				++y;
			}
			if (c >= k) {
				if (c >= k) {
					ans = (ans % INF + (c - k + 1) % INF) % INF;
				}
			}
		}
		for (int j = 1; j < m; j++) {
			int x = n - 1;
			int y = j;
			int c = 0;
			while (x >= 0 && y < m) {
				if (ar[x][y] == 1) {
					++c;
				} else {
					if (c >= k) {
						ans = (ans % INF + (c - k + 1) % INF) % INF;
					}
					c = 0;
				}
				--x;
				++y;
			}
			if (c >= k) {
				if (c >= k) {
					ans = (ans % INF + (c - k + 1) % INF) % INF;
				}
			}
		}

		// left diag
		for (int j = 0; j < m; j++) {
			int x = 0, y = j, c = 0;
			while (x < n && y < m) {
				if (ar[x][y] == 1) {
					++c;
				} else {
					if (c >= k) {
						ans = (ans % INF + (c - k + 1) % INF) % INF;
					}
					c = 0;
				}
				++x;
				++y;
			}
			if (c >= k) {
				if (c >= k) {
					ans = (ans % INF + (c - k + 1) % INF) % INF;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			int x = i, y = 0, c = 0;
			while (x < n && y < m) {
				if (ar[x][y] == 1) {
					++c;
				} else {
					if (c >= k) {
						ans = (ans % INF + (c - k + 1) % INF) % INF;
					}
					c = 0;
				}
				++x;
				++y;
			}
			if (c >= k) {
				if (c >= k) {
					ans = (ans % INF + (c - k + 1) % INF) % INF;
				}
			}
		}
		System.out.println(ans);
	}

	static int _max(int[] ar) {
		intSort(ar, false);
		return ar[ar.length - 1];
	}

	static int _min(int[] ar) {
		intSort(ar, true);
		return ar[ar.length - 1];
	}

	static void intSort(int[] ar, boolean reverse) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i : ar)
			al.add(i);
		Collections.sort(al);
		if (reverse) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = al.get(ar.length - i - 1);
		} else {
			for (int i = 0; i < ar.length; i++)
				ar[i] = al.get(i);
		}
	}

	static void longSort(long[] ar, boolean reverse) {
		ArrayList<Long> al = new ArrayList<Long>();
		for (long i : ar)
			al.add(i);
		Collections.sort(al);
		if (reverse) {
			for (int i = 0; i < ar.length; i++)
				ar[i] = al.get(ar.length - i - 1);
		} else {
			for (int i = 0; i < ar.length; i++)
				ar[i] = al.get(i);
		}
	}

	public static int[] radixSort(int[] f) {
		return radixSort(f, f.length);
	}

	public static int[] radixSort(int[] f, int n) {
		int[] to = new int[n];
		{
			int[] b = new int[65537];
			for (int i = 0; i < n; i++)
				b[1 + (f[i] & 0xffff)]++;
			for (int i = 1; i <= 65536; i++)
				b[i] += b[i - 1];
			for (int i = 0; i < n; i++)
				to[b[f[i] & 0xffff]++] = f[i];
			int[] d = f;
			f = to;
			to = d;
		}
		{
			int[] b = new int[65537];
			for (int i = 0; i < n; i++)
				b[1 + (f[i] >>> 16)]++;
			for (int i = 1; i <= 65536; i++)
				b[i] += b[i - 1];
			for (int i = 0; i < n; i++)
				to[b[f[i] >>> 16]++] = f[i];
			int[] d = f;
			f = to;
			to = d;
		}
		return f;
	}

	static class Pair implements Comparable<Pair> {
		int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public String toString() {
			return "[" + first + "," + second + "]";
		}

		@Override
		public int compareTo(Pair o) {
			if (first != o.first) {
				return first - o.first;
			} else {
				return second - o.second;
			}
		}
	}

	static class LongPair {
		long first;
		long second;

		LongPair(long a, long b) {
			this.first = a;
			this.second = b;
		}

		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void println() {
			writer.print("\n");
		}

		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}

	}

	private static final FastReader fs = new FastReader();
	private static final OutputWriter out = new OutputWriter(System.out);

}