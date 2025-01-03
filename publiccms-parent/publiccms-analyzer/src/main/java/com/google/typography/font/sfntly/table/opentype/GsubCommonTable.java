package com.google.typography.font.sfntly.table.opentype;

import com.google.typography.font.sfntly.data.ReadableFontData;

class GsubCommonTable extends LayoutCommonTable {

    GsubCommonTable(ReadableFontData data, boolean dataIsCanonical) {
        super(data, dataIsCanonical);
    }

    @Override
    protected LookupListTable handleCreateLookupList(ReadableFontData data, boolean dataIsCanonical) {
        return new LookupListTable(data, dataIsCanonical);
    }

    static class Builder extends LayoutCommonTable.Builder {

        protected Builder(ReadableFontData data, boolean dataIsCanonical) {
            super(data, dataIsCanonical);
        }

        protected Builder() {
            super(null, false);
        }

        @Override
        protected LookupListTable handleCreateLookupList(ReadableFontData data, boolean dataIsCanonical) {
            return new LookupListTable(data, dataIsCanonical);
        }

        @Override
        protected GsubCommonTable subBuildTable(ReadableFontData data) {
            return new GsubCommonTable(data, true);
        }

        @Override
        protected LookupListTable.Builder createLookupListBuilder() {
            return new LookupListTable.Builder();
        }

        @Override
        protected int subDataSizeToSerialize() {
            // (cibu): do real implementation
            return 0;
        }

        @Override
        protected void subDataSet() {
            // (cibu): do real implementation
        }
    }
}
