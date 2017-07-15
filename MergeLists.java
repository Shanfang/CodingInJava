
// using divide and conquer

class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class MergeLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}

		helper(lists, 0, lists.size() - 1);
	}

	private ListNode helper(List<ListNode> lists, int start, int end) {
		if (start >= end) {
			return lists.get(start);
		}

		int midList = start + (end - start) / 2;
		ListNode first = helper(lists, start, midList);
		ListNode second = helper(lists, midList + 1, end);
		return mergeTwo(first, second);
	}

	private ListNode mergeTwo(ListNode list1, ListNode list2) {
		if (list2 == null) {
			return list1;
		}
		if (list1 == null) {
			return list2;
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tail.next = list1;
				tail = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				tail = list2;
				list2 = list2.next;
			}
		}
		while (list1 != null) {
			tail.next = list1;
			tail = list1;
			list1 = list1.next;
		}

		while (list2 != null) {
			tail.next = list2;
			tail = list2;
			list2 = list2.next;
		}
		return dummy.next;
	}
}