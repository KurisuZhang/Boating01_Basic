# Neovim

## install

```bash
brew install neovim
apt install neovim
```

## config

```
~/.config/nvim/init.vim
```

## **[vim-plug](https://github.com/junegunn/vim-plug)**

```bash
sh -c 'curl -fLo "${XDG_DATA_HOME:-$HOME/.local/share}"/nvim/site/autoload/plug.vim --create-dirs \
       https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim'
       
       

```

```
PlugInstall
```

```bash
:set number
:set mouse=a
:set autoindent

call plug#begin()
  Plug 'preservim/nerdtree'
  Plug 'ryanoasis/vim-devicons'

call plug#end()


nnoremap <leader>n :NERDTreeFocus<CR>
```

