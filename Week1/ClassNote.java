package Week1;

public class ClassNote {
	public class Tree {
		public void InOrderTraversal(Tree tree) {
			// if tree = nil
			//	return
			//	InOrderTraversal(tree.left)
			//	Print(tree.key)
			//	InOrderTraversal(tree.right)
		}
		
		public void PreOrderTraversal(Tree tree) {
			//	if tree = nil:
			//		return
			//	Print(tree.key)
			//	PreOrderTraversal(tree.left)
			//	PreOrderTraversal(tree.right)
		}
		
		public void PostOrderTraversal(Tree tree) {
			//	if tree = nil:
			//		return
			//	PostOrderTraversal(tree.left)
			//	PostOrderTraversal(tree.right)
			//	Print(tree.key)
		}
		
		public void LevelTraversal(Tree tree) {
			// this is breadth-first search
			//	if tree = nil: return
			//	Queue q
			//	q.Enqueue(tree)
			//	while not q.Empty():
			//		node <- q.Dequeue()
			//		Print(node)
			//		if node.left != nil:
			//			q.Enqueue(node.left)
			//		if node.right != nil
			//			q.Enqueue(node.right)
		}
	}
}
