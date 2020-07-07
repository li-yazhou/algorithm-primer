package org.alpha.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calculation {

	public int main(String exp) {
		List<String> elements = parseToPostfix(exp);
		return calculatePostfix(elements.toArray(new String[elements.size()]));
	}


	private List<String> parseToPostfix(String exp) {
		exp = exp.replaceAll("\\+", " + ");
		exp = exp.replaceAll("-", " - ");
		exp = exp.replaceAll("\\*", " * ");
		exp = exp.replaceAll("/", " / ");
		String[] elements = exp.split(" ");
		List<String> list = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (String element : elements)
		{
			if (0 == elementLevel(element)) {
				list.add(element);
			}
			else if ( stack.isEmpty()
					|| (elementLevel(element) > elementLevel(stack.peek()))) {
				stack.push(element);
			} else {
				while(!stack.isEmpty()
						&& (elementLevel(element) <= elementLevel(stack.peek()))) {
					list.add(stack.pop());
				}
				stack.push(element);
			}
		}
		
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}


	private  int calculatePostfix(String[] postfix) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String element : postfix) {
			if ( 0 == elementLevel(element)) {
				stack.push(Integer.parseInt(element));
			} else {
				int result = apply(element, stack.pop(), stack.pop());
				stack.push(result);
			}
		}
		
		return stack.pop();
	}


	private int elementLevel(String str) {
		if (str.equals("*") || str.equals("/")) {
			return 2;
		} else if (str.equals("+") || str.equals("-")) {
			return 1;
		} else {
			return 0;
		}
	}


	private int apply(String opr, int second, int first) {
		int result;
		char oprChar = opr.charAt(0);
		switch (oprChar) {
			case '+':
				result = first + second;
				break;
			case '-':
				result = first - second;
				break;
			case '*':
				result = first * second;
				break;
			case '/':
				result = first / second;
				break;
			default:
				throw new RuntimeException("异常的元素");
		}
		return result;
	}
}