def flat(iterable):
	for i in iterable:
		try:
			yield from flat(i)
		except TypeError:
			yield i

def all_iters(iterable):
	for i in iterable:
		try:
			yield from all_iters(i)
			yield i
		except TypeError:
			pass

def isolate(list, obj):
	for it in all_iters(list):
		if obj in it and len(it)>1:
			for i in range(len(it)):
				if it[i] == obj:
					it[i] = [obj]
