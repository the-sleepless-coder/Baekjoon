#first half = flavor
# shipment id july의 외래키 

# july flavor = first_half테이블 flavor의 외래키
SELECT j.flavor
from FIRST_HALF fh
join JULY j on fh.FLAVOR = j.FLAVOR
GROUP BY fh.flavor
ORDER BY SUM(j.TOTAL_ORDER) + fh.TOTAL_ORDER DESC
LIMIT 3;
