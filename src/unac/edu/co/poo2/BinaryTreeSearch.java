
package unac.edu.co.poo2;
public class BinaryTreeSearch extends BinaryTree {

	public BinaryTreeSearch() {
		super();
	}

	public Node buscar(Object buscado) {
		Comparator date;
		date = (Comparator) buscado;
		if (root == null)
			return null;
		else
			return localizated(treeRoot(), date);
	}

	protected Node localizated(Node subRoot, Comparator wanted) {
		if (subRoot == null)
			return null;
		else if (wanted.igualQue(subRoot.valueNode()))
			return root;
		else if (wanted.menorQue(subRoot.valueNode()))
			return localizated(subRoot.subTreeL(), wanted);
		else
			return localizated(subRoot.subTreeR(), wanted);
	}

	public Node buscarIterativo(Object wanted) {
		Comparator date;
		boolean encontrado = false;
		Node subRoot = root;
		date = (Comparator) wanted;
		while (!encontrado && subRoot != null) {
			if (date.igualQue(subRoot.valueNode()))
				encontrado = true;
			else if (date.menorQue(subRoot.valueNode()))
				subRoot = subRoot.subTreeL();
			else
				subRoot = subRoot.subTreeR();
		}
		return subRoot;
	}

	public void insert(Object value) throws Exception {
		Comparator date;
		date = (Comparator) value;
		root = insert(root, date);
	}

	protected Node insert(Node raizSub, Comparator date) throws Exception {
		if (raizSub == null)
			raizSub = new Node(date);
		else if (date.menorQue(raizSub.valueNode())) {
			Node iz;
			iz = insert(raizSub.subTreeL(), date);
			raizSub.branchL(iz);
		} else if (date.mayorQue(raizSub.valueNode())) {
			Node dr;
			dr = insert(raizSub.subTreeR(), date);
			raizSub.branchR(dr);
		} else
			throw new Exception("Nodo duplicado");
		return raizSub;
	}

	public void deleted(Object valor) throws Exception {
		Comparator dato;
		dato = (Comparator) valor;
		root = deleted(root, dato);
	}

	protected Node deleted(Node subRoot, Comparator dato) throws Exception {
		if (subRoot == null)
			throw new Exception("No encontrado el nodo con la clave");
		else if (dato.menorQue(subRoot.valueNode())) {
			Node iz;
			iz = deleted(subRoot.subTreeL(), dato);
			subRoot.branchL(iz);
		} else if (dato.mayorQue(subRoot.valueNode())) {
			Node dr;
			dr = deleted(subRoot.subTreeR(), dato);
			subRoot.branchR(dr);
		} else {
			Node q;
			q = subRoot;
			if (q.subTreeL() == null)
				subRoot = q.subTreeR();
			else if (q.subTreeR() == null)
				subRoot = q.subTreeL();
			else {
				q = replace(q);
			}
			q = null;
		}
		return subRoot;
	}

	private Node replace(Node act) {
		Node a, p;
		p = act;
		a = act.subTreeL();
		while (a.subTreeR() != null) {
			p = a;
			a = a.subTreeR();
		}
		act.newValue(a.valueNode());
		if (p == act)
			p.branchL(a.subTreeL());
		else
			p.branchR(a.subTreeL());
		return a;
	}
}
