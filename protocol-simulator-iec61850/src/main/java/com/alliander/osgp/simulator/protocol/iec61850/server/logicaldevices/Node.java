/**
 * Copyright 2017 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package com.alliander.osgp.simulator.protocol.iec61850.server.logicaldevices;

import org.openmuc.openiec61850.BdaType;
import org.openmuc.openiec61850.Fc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Node {

    DSCH1_SCHDID_SETVAL("DSCH1.SchdId.setVal", BdaType.INT32, Fc.SP),
    DSCH1_SCHDTYP_SETVAL("DSCH1.SchdTyp.setVal", BdaType.INT32, Fc.SP),
    DSCH1_SCHDCAT_SETVAL("DSCH1.SchCat.setVal", BdaType.INT32, Fc.SP),
    DSCH1_SCHDABSTM_VAL_0("DSCH1.SchdAbsTm.val.0", BdaType.FLOAT32, Fc.SP),
    DSCH1_SCHDABSTM_TIME_0("DSCH1.SchdAbsTm.time.0", BdaType.TIMESTAMP, Fc.SP),
    DSCH1_SCHDABSTM_VAL_1("DSCH1.SchdAbsTm.val.1", BdaType.FLOAT32, Fc.SP),
    DSCH1_SCHDABSTM_TIME_1("DSCH1.SchdAbsTm.time.1", BdaType.TIMESTAMP, Fc.SP),
    DSCH1_SCHDABSTM_VAL_2("DSCH1.SchdAbsTm.val.2", BdaType.FLOAT32, Fc.SP),
    DSCH1_SCHDABSTM_TIME_2("DSCH1.SchdAbsTm.time.2", BdaType.TIMESTAMP, Fc.SP),
    DSCH1_SCHDABSTM_VAL_3("DSCH1.SchdAbsTm.val.3", BdaType.FLOAT32, Fc.SP),
    DSCH1_SCHDABSTM_TIME_3("DSCH1.SchdAbsTm.time.3", BdaType.TIMESTAMP, Fc.SP),

    DSCH2_SCHDID_SETVAL("DSCH2.SchdId.setVal", BdaType.INT32, Fc.SP),
    DSCH2_SCHDTYP_SETVAL("DSCH2.SchdTyp.setVal", BdaType.INT32, Fc.SP),
    DSCH2_SCHDCAT_SETVAL("DSCH2.SchCat.setVal", BdaType.INT32, Fc.SP),
    DSCH2_SCHDABSTM_VAL_0("DSCH2.SchdAbsTm.val.0", BdaType.FLOAT32, Fc.SP),
    DSCH2_SCHDABSTM_TIME_0("DSCH2.SchdAbsTm.time.0", BdaType.TIMESTAMP, Fc.SP),
    DSCH2_SCHDABSTM_VAL_1("DSCH2.SchdAbsTm.val.1", BdaType.FLOAT32, Fc.SP),
    DSCH2_SCHDABSTM_TIME_1("DSCH2.SchdAbsTm.time.1", BdaType.TIMESTAMP, Fc.SP),
    DSCH2_SCHDABSTM_VAL_2("DSCH2.SchdAbsTm.val.2", BdaType.FLOAT32, Fc.SP),
    DSCH2_SCHDABSTM_TIME_2("DSCH2.SchdAbsTm.time.2", BdaType.TIMESTAMP, Fc.SP),
    DSCH2_SCHDABSTM_VAL_3("DSCH2.SchdAbsTm.val.3", BdaType.FLOAT32, Fc.SP),
    DSCH2_SCHDABSTM_TIME_3("DSCH2.SchdAbsTm.time.3", BdaType.TIMESTAMP, Fc.SP),

    DSCH3_SCHDID_SETVAL("DSCH3.SchdId.setVal", BdaType.INT32, Fc.SP),
    DSCH3_SCHDTYP_SETVAL("DSCH3.SchdTyp.setVal", BdaType.INT32, Fc.SP),
    DSCH3_SCHDCAT_SETVAL("DSCH3.SchCat.setVal", BdaType.INT32, Fc.SP),
    DSCH3_SCHDABSTM_VAL_0("DSCH3.SchdAbsTm.val.0", BdaType.FLOAT32, Fc.SP),
    DSCH3_SCHDABSTM_TIME_0("DSCH3.SchdAbsTm.time.0", BdaType.TIMESTAMP, Fc.SP),
    DSCH3_SCHDABSTM_VAL_1("DSCH3.SchdAbsTm.val.1", BdaType.FLOAT32, Fc.SP),
    DSCH3_SCHDABSTM_TIME_1("DSCH3.SchdAbsTm.time.1", BdaType.TIMESTAMP, Fc.SP),
    DSCH3_SCHDABSTM_VAL_2("DSCH3.SchdAbsTm.val.2", BdaType.FLOAT32, Fc.SP),
    DSCH3_SCHDABSTM_TIME_2("DSCH3.SchdAbsTm.time.2", BdaType.TIMESTAMP, Fc.SP),
    DSCH3_SCHDABSTM_VAL_3("DSCH3.SchdAbsTm.val.3", BdaType.FLOAT32, Fc.SP),
    DSCH3_SCHDABSTM_TIME_3("DSCH3.SchdAbsTm.time.3", BdaType.TIMESTAMP, Fc.SP),

    DSCH4_SCHDID_SETVAL("DSCH4.SchdId.setVal", BdaType.INT32, Fc.SP),
    DSCH4_SCHDTYP_SETVAL("DSCH4.SchdTyp.setVal", BdaType.INT32, Fc.SP),
    DSCH4_SCHDCAT_SETVAL("DSCH4.SchCat.setVal", BdaType.INT32, Fc.SP),
    DSCH4_SCHDABSTM_VAL_0("DSCH4.SchdAbsTm.val.0", BdaType.FLOAT32, Fc.SP),
    DSCH4_SCHDABSTM_TIME_0("DSCH4.SchdAbsTm.time.0", BdaType.TIMESTAMP, Fc.SP),
    DSCH4_SCHDABSTM_VAL_1("DSCH4.SchdAbsTm.val.1", BdaType.FLOAT32, Fc.SP),
    DSCH4_SCHDABSTM_TIME_1("DSCH4.SchdAbsTm.time.1", BdaType.TIMESTAMP, Fc.SP),
    DSCH4_SCHDABSTM_VAL_2("DSCH4.SchdAbsTm.val.2", BdaType.FLOAT32, Fc.SP),
    DSCH4_SCHDABSTM_TIME_2("DSCH4.SchdAbsTm.time.2", BdaType.TIMESTAMP, Fc.SP),
    DSCH4_SCHDABSTM_VAL_3("DSCH4.SchdAbsTm.val.3", BdaType.FLOAT32, Fc.SP),
    DSCH4_SCHDABSTM_TIME_3("DSCH4.SchdAbsTm.time.3", BdaType.TIMESTAMP, Fc.SP),

    LLN0_HEALTH_STVAL("LLN0.Health.stVal", BdaType.INT8, Fc.ST),
    LLN0_HEALTH_Q("LLN0.Health.q", BdaType.QUALITY, Fc.ST),
    LLN0_HEALTH_T("LLN0.Health.t", BdaType.TIMESTAMP, Fc.ST),

    LLN0_BEH_STVAL("LLN0.Beh.stVal", BdaType.INT8, Fc.ST),
    LLN0_BEH_Q("LLN0.Beh.q", BdaType.QUALITY, Fc.ST),
    LLN0_BEH_T("LLN0.Beh.t", BdaType.TIMESTAMP, Fc.ST),

    LLN0_MOD_STVAL("LLN0.Mod.stVal", BdaType.INT8, Fc.ST),
    LLN0_MOD_Q("LLN0.Mod.q", BdaType.QUALITY, Fc.ST),
    LLN0_MOD_T("LLN0.Mod.t", BdaType.TIMESTAMP, Fc.ST),

    MMXU1_MAXWPHS_MAG_F("MMXU1.MaxWPhs.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_MAXWPHS_Q("MMXU1.MaxWPhs.q", BdaType.QUALITY, Fc.MX),
    MMXU1_MAXWPHS_T("MMXU1.MaxWPhs.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU1_MINWPHS_MAG_F("MMXU1.MinWPhs.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_MINWPHS_Q("MMXU1.MinWPhs.q", BdaType.QUALITY, Fc.MX),
    MMXU1_MINWPHS_T("MMXU1.MinWPhs.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU1_TOTW_MAG_F("MMXU1.TotW.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_TOTW_Q("MMXU1.TotW.q", BdaType.QUALITY, Fc.MX),
    MMXU1_TOTW_T("MMXU1.TotW.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU1_TOTPF_MAG_F("MMXU1.TotPF.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_TOTPF_Q("MMXU1.TotPF.q", BdaType.QUALITY, Fc.MX),
    MMXU1_TOTPF_T("MMXU1.TotPF.t", BdaType.TIMESTAMP, Fc.MX),

    DRCC1_OUTWSET_SUBVAL_F("DRCC1.OutWSet.subVal.f", BdaType.FLOAT32, Fc.SV),
    DRCC1_OUTWSET_SUBQ("DRCC1.OutWSet.subQ", BdaType.QUALITY, Fc.SV),

    DGEN1_TOTWH_MAG_F("DGEN1.TotWh.mag.f", BdaType.FLOAT32, Fc.MX),
    DGEN1_TOTWH_Q("DGEN1.TotWh.q", BdaType.QUALITY, Fc.MX),
    DGEN1_TOTWH_T("DGEN1.TotWh.t", BdaType.TIMESTAMP, Fc.MX),

    DGEN1_GNOPST_STVAL("DGEN1.GnOpSt.stVal", BdaType.INT8, Fc.ST),
    DGEN1_GNOPST_Q("DGEN1.GnOpSt.q", BdaType.QUALITY, Fc.ST),
    DGEN1_GNOPST_T("DGEN1.GnOpSt.t", BdaType.TIMESTAMP, Fc.ST),

    DGEN1_OPTMSRS_STVAL("DGEN1.OpTmsRs.stVal", BdaType.INT32, Fc.ST),
    DGEN1_OPTMSRS_Q("DGEN1.OpTmsRs.q", BdaType.QUALITY, Fc.ST),
    DGEN1_OPTMSRS_T("DGEN1.OpTmsRs.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_ALM1_STVAL("GGIO1.Alm1.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_ALM1_Q("GGIO1.Alm1.q", BdaType.QUALITY, Fc.ST),
    GGIO1_ALM1_T("GGIO1.Alm1.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_ALM2_STVAL("GGIO1.Alm2.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_ALM2_Q("GGIO1.Alm2.q", BdaType.QUALITY, Fc.ST),
    GGIO1_ALM2_T("GGIO1.Alm2.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_ALM3_STVAL("GGIO1.Alm3.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_ALM3_Q("GGIO1.Alm3.q", BdaType.QUALITY, Fc.ST),
    GGIO1_ALM3_T("GGIO1.Alm3.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_ALM4_STVAL("GGIO1.Alm4.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_ALM4_Q("GGIO1.Alm4.q", BdaType.QUALITY, Fc.ST),
    GGIO1_ALM4_T("GGIO1.Alm4.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_INTIN1_STVAL("GGIO1.IntIn1.stVal", BdaType.INT32, Fc.ST),
    GGIO1_INTIN1_Q("GGIO1.IntIn1.q", BdaType.QUALITY, Fc.ST),
    GGIO1_INTIN1_T("GGIO1.IntIn1.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_INTIN2_STVAL("GGIO1.IntIn2.stVal", BdaType.INT32, Fc.ST),
    GGIO1_INTIN2_Q("GGIO1.IntIn2.q", BdaType.QUALITY, Fc.ST),
    GGIO1_INTIN2_T("GGIO1.IntIn2.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_WRN1_STVAL("GGIO1.Wrn1.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_WRN1_Q("GGIO1.Wrn1.q", BdaType.QUALITY, Fc.ST),
    GGIO1_WRN1_T("GGIO1.Wrn1.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_WRN2_STVAL("GGIO1.Wrn2.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_WRN2_Q("GGIO1.Wrn2.q", BdaType.QUALITY, Fc.ST),
    GGIO1_WRN2_T("GGIO1.Wrn2.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_WRN3_STVAL("GGIO1.Wrn3.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_WRN3_Q("GGIO1.Wrn3.q", BdaType.QUALITY, Fc.ST),
    GGIO1_WRN3_T("GGIO1.Wrn3.t", BdaType.TIMESTAMP, Fc.ST),

    GGIO1_WRN4_STVAL("GGIO1.Wrn4.stVal", BdaType.BOOLEAN, Fc.ST),
    GGIO1_WRN4_Q("GGIO1.Wrn4.q", BdaType.QUALITY, Fc.ST),
    GGIO1_WRN4_T("GGIO1.Wrn4.t", BdaType.TIMESTAMP, Fc.ST),

    TTMP1_TMPSV_INSTMAG_F("TTMP1.TmpSv.instMag.f", BdaType.FLOAT32, Fc.MX),
    TTMP1_TMPSV_Q("TTMP1.TmpSv.q", BdaType.QUALITY, Fc.MX),
    TTMP1_TMPSV_T("TTMP1.TmpSv.t", BdaType.TIMESTAMP, Fc.MX),
    TTMP2_TMPSV_INSTMAG_F("TTMP2.TmpSv.instMag.f", BdaType.FLOAT32, Fc.MX),
    TTMP2_TMPSV_Q("TTMP2.TmpSv.q", BdaType.QUALITY, Fc.MX),
    TTMP2_TMPSV_T("TTMP2.TmpSv.t", BdaType.TIMESTAMP, Fc.MX),
    TTMP3_TMPSV_INSTMAG_F("TTMP3.TmpSv.instMag.f", BdaType.FLOAT32, Fc.MX),
    TTMP3_TMPSV_Q("TTMP3.TmpSv.q", BdaType.QUALITY, Fc.MX),
    TTMP3_TMPSV_T("TTMP3.TmpSv.t", BdaType.TIMESTAMP, Fc.MX),
    TTMP4_TMPSV_INSTMAG_F("TTMP4.TmpSv.instMag.f", BdaType.FLOAT32, Fc.MX),
    TTMP4_TMPSV_Q("TTMP4.TmpSv.q", BdaType.QUALITY, Fc.MX),
    TTMP4_TMPSV_T("TTMP4.TmpSv.t", BdaType.TIMESTAMP, Fc.MX),

    MFLW1_FLWRTE_MAG_F("MFLW1.FlwRte.mag.f", BdaType.FLOAT32, Fc.MX),
    MFLW1_FLWRTE_Q("MFLW1.FlwRte.q", BdaType.QUALITY, Fc.MX),
    MFLW1_FLWRTE_T("MFLW1.FlwRte.t", BdaType.TIMESTAMP, Fc.MX),

    MFLW2_FLWRTE_MAG_F("MFLW2.FlwRte.mag.f", BdaType.FLOAT32, Fc.MX),
    MFLW2_FLWRTE_Q("MFLW2.FlwRte.q", BdaType.QUALITY, Fc.MX),
    MFLW2_FLWRTE_T("MFLW2.FlwRte.t", BdaType.TIMESTAMP, Fc.MX),

    KTNK1_VLMCAP_SETMAG_F("KTNK1.VlmCap.setMag.f", BdaType.FLOAT32, Fc.SP),

    MMXU2_TOTW_MAG_F("MMXU2.TotW.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU2_TOTW_Q("MMXU2.TotW.q", BdaType.QUALITY, Fc.MX),
    MMXU2_TOTW_T("MMXU2.TotW.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU2_MINWPHS_MAG_F("MMXU2.MinWPhs.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU2_MINWPHS_Q("MMXU2.MinWPhs.q", BdaType.QUALITY, Fc.MX),
    MMXU2_MINWPHS_T("MMXU2.MinWPhs.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU2_MAXWPHS_MAG_F("MMXU2.MaxWPhs.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU2_MAXWPHS_Q("MMXU2.MaxWPhs.q", BdaType.QUALITY, Fc.MX),
    MMXU2_MAXWPHS_T("MMXU2.MaxWPhs.t", BdaType.TIMESTAMP, Fc.MX),

    MMTR1_TOTWH_ACTVAL("MMTR1.TotWh.actVal", BdaType.INT64, Fc.ST),
    MMTR1_TOTWH_Q("MMTR1.TotWh.q", BdaType.QUALITY, Fc.ST),
    MMTR1_TOTWH_T("MMTR1.TotWh.t", BdaType.TIMESTAMP, Fc.ST),

    MMXU1_W_PHSA_CVAL_MAG_F("MMXU1.W.phsA.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_W_PHSA_Q("MMXU1.W.phsA.q", BdaType.QUALITY, Fc.MX),
    MMXU1_W_PHSA_T("MMXU1.W.phsA.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU1_W_PHSB_CVAL_MAG_F("MMXU1.W.phsB.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_W_PHSB_Q("MMXU1.W.phsB.q", BdaType.QUALITY, Fc.MX),
    MMXU1_W_PHSB_T("MMXU1.W.phsB.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU1_W_PHSC_CVAL_MAG_F("MMXU1.W.phsC.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU1_W_PHSC_Q("MMXU1.W.phsC.q", BdaType.QUALITY, Fc.MX),
    MMXU1_W_PHSC_T("MMXU1.W.phsC.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU2_W_PHSA_CVAL_MAG_F("MMXU2.W.phsA.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU2_W_PHSA_Q("MMXU2.W.phsA.q", BdaType.QUALITY, Fc.MX),
    MMXU2_W_PHSA_T("MMXU2.W.phsA.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU2_W_PHSB_CVAL_MAG_F("MMXU2.W.phsB.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU2_W_PHSB_Q("MMXU2.W.phsB.q", BdaType.QUALITY, Fc.MX),
    MMXU2_W_PHSB_T("MMXU2.W.phsB.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU2_W_PHSC_CVAL_MAG_F("MMXU2.W.phsC.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU2_W_PHSC_Q("MMXU2.W.phsC.q", BdaType.QUALITY, Fc.MX),
    MMXU2_W_PHSC_T("MMXU2.W.phsC.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU3_W_PHSA_CVAL_MAG_F("MMXU3.W.phsA.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU3_W_PHSA_Q("MMXU3.W.phsA.q", BdaType.QUALITY, Fc.MX),
    MMXU3_W_PHSA_T("MMXU3.W.phsA.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU3_W_PHSB_CVAL_MAG_F("MMXU3.W.phsB.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU3_W_PHSB_Q("MMXU3.W.phsB.q", BdaType.QUALITY, Fc.MX),
    MMXU3_W_PHSB_T("MMXU3.W.phsB.t", BdaType.TIMESTAMP, Fc.MX),

    MMXU3_W_PHSC_CVAL_MAG_F("MMXU3.W.phsC.cVal.mag.f", BdaType.FLOAT32, Fc.MX),
    MMXU3_W_PHSC_Q("MMXU3.W.phsC.q", BdaType.QUALITY, Fc.MX),
    MMXU3_W_PHSC_T("MMXU3.W.phsC.t", BdaType.TIMESTAMP, Fc.MX),

    SPGGIO1_IND_D("SPGGIO1.Ind.d", BdaType.VISIBLE_STRING, Fc.DC),
    SPGGIO1_IND_STVAL("SPGGIO1.Ind.stVal", BdaType.BOOLEAN, Fc.ST),
    SPGGIO2_IND_STVAL("SPGGIO2.Ind.stVal", BdaType.BOOLEAN, Fc.ST),
    SPGGIO3_IND_STVAL("SPGGIO3.Ind.stVal", BdaType.BOOLEAN, Fc.ST),
    SPGGIO4_IND_STVAL("SPGGIO4.Ind.stVal", BdaType.BOOLEAN, Fc.ST),

    LLN0_REPORTMEASUREMENTS_01_RPT_ENA("LLN0.ReportMeasurements01.RptEna", BdaType.BOOLEAN, Fc.ST),
    LLN0_REPORTMEASUREMENTS_02_RPT_ENA("LLN0.ReportMeasurements02.RptEna", BdaType.BOOLEAN, Fc.ST),
    LLN0_REPORTSTATUS_01_RPT_ENA("LLN0.ReportStatus01.RptEna", BdaType.BOOLEAN, Fc.ST),
    LLN0_REPORTSTATUS_02_RPT_ENA("LLN0.ReportStatus02.RptEna", BdaType.BOOLEAN, Fc.ST);

    private static final Logger LOGGER = LoggerFactory.getLogger(Node.class);

    private String description;
    private BdaType type;
    private Fc fc;

    Node(final String description, final BdaType type, final Fc fc) {
        this.description = description;
        this.type = type;
        this.fc = fc;
    }

    public String getDescription() {
        return this.description;
    }

    public BdaType getType() {
        return this.type;
    }

    public Fc getFc() {
        return this.fc;
    }

    public static Node fromDescription(final String description) {
        for (final Node node : Node.values()) {
            if (node.description.equals(description)) {
                return node;
            }
        }
        LOGGER.warn("No node with description {} found", description);
        return null;
    }

}
