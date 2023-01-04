def flat(iterable):
	for i in iterable:
		try:
			yield from flat(i)
		except TypeError:
			yield i
