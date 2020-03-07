All documentation has been done using javadoc

There is one small bug, which after several hours I was unable to fix.  When data is sent to the POST endpoint,
all the data is saved, but the foreign key for logs in the account table is not filled in.
This results in some data for accounts not being retrieved properly.

Also, in order to make this cloud-scalable, we would want to set up the storage so that it was stored as some sort 
of a tree, possibly an AVL tree.  That way we could store the data in a sorted manner, and query all of that data
in a much more efficient manner.