package facebook;

public class Test {

	public static void main(String[] args) {
		
//		Graph g = (new GraphBuilder())
//				.setFileSuffix("edges")
//				.setLocation(Paths.get("facebook/"))
//				.build();
//
////		g.bfs(236, 3);
//		FacebookGraph fb = new FacebookGraph(g);
//		fb.addObserver(new NewFriendObserver());		
//		fb.addEdge(233, 4);
		
		
		//fb.findFriendsOfFriends(236);
		//fb.accept(new EvenNodeVisitor());

		
		Graph g = new BasicGraph();
		FacebookGraph fb = new FacebookGraph(g);
		fb.addObserver(new UnfriendObserver());
		
		fb.addEdge(1, 2);
		fb.addEdge(1, 3);

		fb.addEdge(2, 4);
		fb.addEdge(2, 5);

		fb.addEdge(3, 1);
		
		fb.addEdge(4, 2);
		fb.addEdge(4, 6);
		
		fb.addEdge(5, 2);
		fb.addEdge(5, 6);

		fb.addEdge(6, 4);
		fb.addEdge(6, 5);

		fb.bfs(1);
		
		fb.removeEdge(2, 5);

		fb.bfs(1);

	}
	
}
