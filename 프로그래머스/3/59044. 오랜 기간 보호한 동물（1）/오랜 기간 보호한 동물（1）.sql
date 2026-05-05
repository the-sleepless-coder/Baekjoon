# 입양 가지 않는 친구들 중, 
# 가장 오래된 것을 들어온 오름차순으로 정렬한다.
# 결과는 3개 보여준다.
SELECT ai.NAME, ai.DATETIME
from ANIMAL_INS ai
LEFT JOIN ANIMAL_OUTS ao on ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ao.ANIMAL_ID IS NULL
ORDER BY (now() - ai.DATETIME) DESC, DATETIME ASC
LIMIT 3
;
