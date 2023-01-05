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
