Tutorial
-----------
See tutorial at https://ammar64.github.io/Sharing/Tutorial/

Understand the structure
-----------

the [common](common) directory contains resources used by different pages<br>
each page has its own html file in the [pages](pages) folder and has a directory that contains resources used in the page

always add images to an `images` directory and fonts to `fonts` directories.<br>

Note
----------

To get the web pages to work properly with the live server extension you need to clone this branch this way
```bash
git clone https://github.com/Ammar64/Sharing -b tutorial
```
you will get a directory named `Sharing`.
make a new dir and move `Sharing` to it.

assuming the new created directory is named `example`.
this is how you would do it.

```bash
mkdir example
mv Sharing/ example/
```

then open `example` in [VS Codium](https://vscodium.com/) (because it's FLOSS) then open `index.html` using live server.
