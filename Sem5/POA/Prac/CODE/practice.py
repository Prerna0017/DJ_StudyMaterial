def lru(pages , n, capacity):
    s = set()
    indexes = {}
    pageFault=0
    for i in range(n):
        if len(s) < capacity:
            if pages[i] not in s:
                s.add(pages[i])
                pageFault+=1
            indexes[pages[i]] = i
        else:
            if pages[i] not in s:
                lru = float('inf')
                for page in s:
                    if indexes[page] <lru:
                        lru = indexes[page]
                        val = page
                s.remove(val)
                pageFault+=1
                s.add(pages[i])
                indexes[pages[i]] = i
        print(s)

    return pageFault

pages = [7, 0, 1, 2, 0, 3, 0, 
				4, 2, 3, 0, 3, 2] 
n = len(pages) 
capacity = 4
print(lru(pages, n, capacity)) 
        