package project.Myprj.domain;

import lombok.Getter;
import lombok.Setter;


public class Pagination {

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getTotalListCnt() {
        return totalListCnt;
    }

    public void setTotalListCnt(int totalListCnt) {
        this.totalListCnt = totalListCnt;
    }

    public int getTotalPageCnt() {
        return totalPageCnt;
    }

    public void setTotalPageCnt(int totalPageCnt) {
        this.totalPageCnt = totalPageCnt;
    }

    public int getTotalBlockCnt() {
        return totalBlockCnt;
    }

    public void setTotalBlockCnt(int totalBlockCnt) {
        this.totalBlockCnt = totalBlockCnt;
    }

    public int getStartPage() {
        return StartPage;
    }

    public void setStartPage(int startPage) {
        this.StartPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPrevBlock() {
        return prevBlock;
    }

    public void setPrevBlock(int prevBlock) {
        this.prevBlock = prevBlock;
    }

    public int getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(int nextBlock) {
        this.nextBlock = nextBlock;
    }

    public Pagination(int totalListCnt, int page) {

        this.page = page; // 현재 페이지 지정
        this.totalListCnt = totalListCnt; // 총 게시글 수 지정

        // 총 게시글 수를 지정
        // 게시글 수를 pageSize로 나누어 페이지 수를 정함
        setTotalPageCnt((int) Math.ceil(totalListCnt * 1.0 / pageSize));

        // 전체 페이지 수를 지정한 블록 수(블록 당 페이지 수)로 나누어 블록 수 지정
        setTotalBlockCnt((int) Math.ceil(totalPageCnt * 1.0 / blockSize));

        // 현재 현재 페이지를 블록 사이즈로 나누어 현재 블록 주소 지정
        setBlock((int) Math.ceil((page * 1.0)/blockSize));

        // 블럭 내 시작 페이지 설정
        setStartPage((block - 1) * blockSize + 1);

        // 블럭내 마지막페이지 설정
        setEndPage(StartPage + blockSize - 1);

        /* === 블럭 마지막 페이지에 대한 validation ===*/
        if(endPage > totalPageCnt){this.endPage = totalPageCnt;}


        /** 이전 블럭의 마지막 페이지  - 이전 버튼을 의미**/
        setPrevBlock((block * blockSize) - blockSize);


        /* 이전 블럭이 1보다 작을 경우 안되므로 지정 */
        if(prevBlock < 1) {this.prevBlock = 1;}


        /** 다음 블럭 클릭 시 지정되는 Page Num **/
        setNextBlock((block * blockSize) + 1);


        /* === 다음 블럭에 대한 validation ===*/
        if(nextBlock > totalPageCnt) {nextBlock = totalPageCnt;}


        /** 10. DB 접근 시작 index **/
        setStartIndex((page-1) * pageSize);
    }


    private int pageSize = 10; // 페이지 당 보여지는 게시글 최대 개수
    private int blockSize = 10; // 페이징된 버튼의 블럭당 최대 개수

    private int page = 1; // 현재 페이지
    private int block = 1; // 현재 블럭

    private int totalListCnt; // 총 게시글 수
    private int totalPageCnt; // 총 페이지 수
    private int totalBlockCnt; // 총 블럭 수

    private int StartPage =1; // 블럭 시작 페이지
    private int endPage =1; // 블럭 마지막 페이지

    private int startIndex =0; // DB 접근 시작 index
    private int prevBlock; // 이전 블럭의 마지막 페이지
    private int nextBlock; // 다음 블럭의 시작 페이지
}
