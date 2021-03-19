/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static long orientation(ArrayList<Long> p, ArrayList<Long>  q, ArrayList<Long>  r) {
        return (q.get(1) - p.get(1)) * (r.get(0) - q.get(0)) - (q.get(0) - p.get(0)) * (r.get(1) - q.get(1));
    }
    public static long distance(ArrayList<Long> p, ArrayList<Long> q) {
        return (p.get(0) - q.get(0)) * (p.get(0) - q.get(0)) + (p.get(1) - q.get(1)) * (p.get(1) - q.get(1));
    }

    private static ArrayList<Long> bottomLeft(ArrayList<ArrayList<Long>> points) {
        ArrayList<Long> bottomLeft = points.get(0);
        for (ArrayList<Long> p: points)
            if (p.get(1) < bottomLeft.get(1))
                bottomLeft = p;
        return bottomLeft;
    }
    public static ArrayList<ArrayList<Long>> convexHull(ArrayList<ArrayList<Long>> points) 
    {
            if (points.size() <= 1)
                return points;
            ArrayList<Long> bm = bottomLeft(points);
            Collections.sort(points, new Comparator<ArrayList<Long>> () {
                public int compare(ArrayList<Long> p, ArrayList<Long> q) {
                double diff = orientation(bm, p, q) - orientation(bm, q, p);
                if (diff == 0)
                    return (int)(distance(bm, p) - distance(bm, q));
                else
                    return diff > 0 ? 1 : -1;
            }
        });
        int i = points.size() - 1;
        while (i >= 0 && orientation(bm, points.get(points.size() - 1), points.get(i)) == 0)
            i--;
        for (int l = i + 1, h = points.size() - 1; l < h; l++, h--) {
            Collections.swap(points, l, h);
            // int[] temp = points[l];
            // points[l] = points[h];
            // points[h] = temp;
        }
        Stack<ArrayList<Long>> stack = new Stack<>();
        stack.push(points.get(0));
        stack.push(points.get(1));
        for (int j = 2; j < points.size(); j++) {
            ArrayList<Long> top = stack.pop();
            while (orientation(stack.peek(), top, points.get(j)) > 0)
                top = stack.pop();
            stack.push(top);
            stack.push(points.get(j));
        }
        
        return new ArrayList(stack);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int t = Integer.parseInt(br.readLine());
		    for(int p=0;p<t;p++)
		    {
		        String[] nb = br.readLine().trim().split("\\s+");
		        int n = Integer.parseInt(nb[0]);
		        int b = Integer.parseInt(nb[1]);
                ArrayList<ArrayList<Long> > points =  new ArrayList<ArrayList<Long> >(n);		        
                for(int i = 0; i<n; i++)
		        {
		            ArrayList<Long> point = new ArrayList<Long>(); 
		            String[] xy = br.readLine().trim().split("\\s+");
		            long x = Long.parseLong(xy[0]);
		            long y = Long.parseLong(xy[1]);
		            point.add(x);
		            point.add(y);
		            points.add(point);
		        }
		        int zone = 0;
		        while(points.size()!=0)
		        {
		            ArrayList<ArrayList<Long>> toremove = convexHull(points);
		            points.removeAll(toremove);
		            zone++;
		        }
		        zone = zone-1;
		        if(zone == 1)
		        {
		            System.out.println(b);
		        } else if(zone == 2)
		        {
		            System.out.println(b);
		        } else{
		            long[] f = new long[zone];
		            f[0] = 1;
		            f[1] = 1;
		            long sum = 2;
		            for(int i = 2; i<zone; i++)
		            {
		                f[i] = f[i-1]+f[i-2];
		                sum += f[i];
		            }
		            long ans = sum*b;
		            ans /= zone;
		            System.out.println(ans);
		        }
		       
		    }

		}catch(Exception e){
		    System.out.println(e);
		}
	}
}
